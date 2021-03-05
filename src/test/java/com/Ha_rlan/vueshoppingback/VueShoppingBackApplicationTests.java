package com.Ha_rlan.vueshoppingback;

import com.Ha_rlan.vueshoppingback.entity.Manager;
import com.Ha_rlan.vueshoppingback.service.Impl.IManagerServiceImpl;
import com.Ha_rlan.vueshoppingback.service.Impl.IPermissionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@WebAppConfiguration
class VueShoppingBackApplicationTests {
    @Resource
    private JavaMailSender javaMailSender;
    @Autowired
    IPermissionServiceImpl iPermissionService;
    @Autowired
    IManagerServiceImpl iManagerService;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2564776749@qq.com");
        message.setTo("2146751042@qq.com");
        message.setSubject("测试邮件");
        message.setText("我叫你一声你敢答应吗");
        this.javaMailSender.send(message);
    }
    @Test
    void generateCode(){
        //生成10以内随机数的代码
        int[] nums = new int[6];
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = (int) Math.floor(Math.random()*10);
            nums[i] = num;
        }
//        使用for循环遍历拼接
        for (int num : nums) {
            code.append(num);
        }
        System.out.println(code.toString());
//        思考下怎么将这6个数字拼成一个字符串
//        思路一：一个一个拿出来硬拼
//        思路二：在生成的时候就转变成字符串，然后存到一个集合中，通过操作字符串进行拼接；这样还要new一个StringBuilder

    }
    @Test
    void selectTest(){
        iPermissionService.list();
    }
    @Test
    void managerBasic(){
       List<Manager> list = iManagerService.selectByPage(1,2,null);
       list.forEach(
               System.out::println
       );
    }
    @Test
    void hackString(){
        String permission = "101,0,104,116,115,142,143,144,121,122,123,149,102,107,109,103,111,129,130,134,135,138,139,140,141,112,147,125,110,131,132,133,136,137,145,146,148";
        String[] strings = permission.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(Arrays.toString(nums));
    }
    public void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {// 第i个和第j个比较j可以取到最后一位，所以要用j<=array.length-1
                if (array[i] > array[j]) {// 注意和冒泡排序的区别，这里是i和j比较。
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    @Test
    void sortTest(){
        int[] nums = {3,5,2,4,1};
        selectionSort(nums);
    }
    @Test
    public void remove(){
        String[] strings = {"1","2","3"};
        List<String> list = Arrays.asList(strings);
        List<String> list1 = new ArrayList<>(list);
        list1.remove("1");
        System.out.println(Arrays.toString(strings));
    }
}
