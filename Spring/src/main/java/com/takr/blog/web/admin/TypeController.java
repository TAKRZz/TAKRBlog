package com.takr.blog.web.admin;

import com.takr.blog.po.Type;
import com.takr.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;


    @GetMapping("/types")
    public String list(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model){

        model.addAttribute("page", typeService.listType(pageable));

        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(){
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String post(Type type, RedirectAttributes attributes){
        Type type1 = typeService.saveType(type);
        if(null == type1){
            attributes.addFlashAttribute("message", "操作失败");
        }else{
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/types";
    }

}
