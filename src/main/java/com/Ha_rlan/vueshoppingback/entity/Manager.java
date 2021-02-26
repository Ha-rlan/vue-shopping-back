package com.Ha_rlan.vueshoppingback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    public int id;
    public String name;
    public String password;
    public Long time;
    public int role_id;
    public String role_name;
    public String phone;
    public String email;
//    current state
    public boolean state;
}
