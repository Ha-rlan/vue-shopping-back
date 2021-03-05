package com.Ha_rlan.vueshoppingback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    public int id;
    public String name;
    public int parent_id;
    public String controller;
    public String control_function;
    public String level;
    public List<Permission> children;
    public String path;
}
