package com.takr.blog.web.admin;


import com.takr.blog.po.Blog;
import com.takr.blog.service.BlogService;
import com.takr.blog.service.TypeService;
import com.takr.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blogQuery, Model model){

        model.addAttribute("types",typeService.listType());

        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));

        return "admin/blogs";
    }

    @GetMapping("/blogs/search")
    public String search(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blogQuery, Model model){

        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));

        return "admin/blogs :: blogList";
    }

}
