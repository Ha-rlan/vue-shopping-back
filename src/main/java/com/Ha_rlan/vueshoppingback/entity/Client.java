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
   public  String username;
   public  String password;
   public  String email;
}
