/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.reimbursement.reimbursement.controllers;

import id.co.mii.reimbursement.reimbursement.models.Category;
import id.co.mii.reimbursement.reimbursement.services.GeneralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author amry4
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    protected GeneralService generalService;

    @RequestMapping(value = "tambah", method = RequestMethod.POST)
    public String adding(@ModelAttribute("category") Category cat) {
        generalService.manageData(cat, "", "", "", true, false);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Category> listcat = generalService.manageData(new Category(), "name", "", "", false, true);
        model.addAttribute("categories", listcat);
        System.out.println(listcat);
        return "category";
    }

    @RequestMapping("/delete/{id}")
    public String Delete(@PathVariable(name = "id") int id) {
        generalService.manageData(new Category(), "", "", id, true, true);
        return "redirect:/category/";
    }

}
