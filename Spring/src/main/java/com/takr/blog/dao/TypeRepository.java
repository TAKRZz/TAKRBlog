package com.takr.blog.dao;

import com.takr.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {


    Type findByName(String name);

}
