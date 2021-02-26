package com.Ha_rlan.vueshoppingback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client {
   public  int id;
   public  String username;
   public  int role_id;
   public  String password;
   public  String phone;
   public  String email;
   public  enum is_active{};
   public  String role_name;
   public  enum grade{};
   public  String qq;
   public  enum education{};
   public  String hobby;
   public  String introduce;
   public  String create_time;
   public  String update_time;

}
