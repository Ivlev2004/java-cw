package com.example.payday.controllers;

import com.example.payday.models.User;
import com.example.payday.services.EmpTransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class EmpTransactionController {

    private final EmpTransactionService empTransactionService;

    public EmpTransactionController(EmpTransactionService empTransactionService) {
        this.empTransactionService = empTransactionService;
    }

    @GetMapping("/")
    public String empTransactions(@RequestParam(name = "textSummary", required = false) String textSummary, Principal principal, Model model) {
        if (textSummary != null) {
            Double summary = Double.parseDouble(textSummary);
            model.addAttribute("empTransactions", empTransactionService.listEmpTransaction(summary));
        }
        else {
            model.addAttribute("empTransactions", empTransactionService.listEmpTransaction(null));
        }
        model.addAttribute("user", empTransactionService.getUserByPrincipal(principal));
        return "main-page";
    }

    @GetMapping("/transaction/{id}")
    public String empTransactionInfo(@PathVariable Long id, Model model) {
        model.addAttribute("transaction", empTransactionService.getTransactionById(id));
        return "transaction-info";
    }

    @PostMapping("/transaction/create")
    public String createEmpTransaction(@RequestParam(name = "textSummary") String textSummary,
                                       @RequestParam(name = "recipientId") Long id, Principal principal, RedirectAttributes redirectAttributes) {
        User sender = empTransactionService.getUserByPrincipal(principal);
        User recipient = empTransactionService.getUserById(id);
        Long adminId = (long) 6;
        User admin = empTransactionService.getUserById(adminId);


        System.out.println(admin.getAccountBalance());

        if (sender.isAccountant()) {
            if (recipient.isAdmin()) {
                redirectAttributes.addFlashAttribute("message", "Вы не можете осуществить перевод администратору");
                return "redirect:/";
            } else if (recipient.isAccountant()) {
                redirectAttributes.addFlashAttribute("message", "Вы не можете осуществить перевод бухгалтеру");
                return "redirect:/";
            }
        }

        Double summary = Double.parseDouble(textSummary);
        if (admin.getAccountBalance() < summary) {
            redirectAttributes.addFlashAttribute("message", "Недостаточно средств");
            return "redirect:/";
        } else {
            admin.setAccountBalance(admin.getAccountBalance() - summary);
        }

        recipient.setAccountBalance(recipient.getAccountBalance() + summary);
        empTransactionService.saveEmpTransaction(recipient, summary, sender);

        return "redirect:/";
    }

    @GetMapping("/my/transactions")
    public String userEmpTransactions(Principal principal, Model model) {
        User user = empTransactionService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("transactions", user.getRecTransactions());
        return "my-transactions";
    }

    @GetMapping("/my/transactions/{id}")
    public String userReservation(@PathVariable Long id, Model model) {
        User user = empTransactionService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("transactions", user.getRecTransactions());
        return "my-transactions";
    }
}
