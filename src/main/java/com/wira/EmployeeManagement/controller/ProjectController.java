package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Project;
import com.wira.EmployeeManagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/report")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepositoryJpa.findAll(new PageRequest(page, 4)));
        model.addAttribute("projects", projectRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageProject", page);
        model.addAttribute ( "buatProject", new Project());
        return "/project/project.html";
    }

    @PostMapping("/save")
    public String save(@Valid Project project, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "redirect:/project";
        }

        projectRepository.save(project);

        return "redirect:/project";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("projectId") long projectId) {
        projectRepository.deleteById(projectId);

        return "redirect:/project";
    }
}
