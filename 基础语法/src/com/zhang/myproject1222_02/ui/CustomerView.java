package com.zhang.myproject1222_02.ui;

import com.zhang.myproject1222_02.bean.Customer;
import com.zhang.myproject1222_02.service.CustomerList;
import com.zhang.myproject1222_02.util.CMUtility;

public class CustomerView {
    private CustomerList customerList= new CustomerList(10);
    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("-----------------客户信息管理软件-----------------\n" +
                    "\n" +
                    "1 添 加 客 户\n" +
                    "2 修 改 客 户\n" +
                    "3 删 除 客 户\n" +
                    "4 客 户 列 表\n" +
                    "5 退       出\n" +
                    "\n" +
                    "请选择(1-5)：_\n");
            char menu = CMUtility.readMenuSelection();
            switch(menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N)");
                    char isY = CMUtility.readConfirmSelection();
                    if(isY =='Y'){
                        isFlag = false;
                    }
                    break;
            }
        }
    }
    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.print("请输入姓名：");
        String name = CMUtility.readString(5);
        System.out.print("请输入性别：");
        char gender = CMUtility.readChar();
        System.out.print("请输入年龄：");
        int age = CMUtility.readInt();
        System.out.print("请输入手机号：");
        String phone = CMUtility.readString(11);
        System.out.print("请输入邮箱：");
        String email = CMUtility.readString(20);
        Customer cust = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(cust);
        if(isSuccess){
            System.out.println("---------------------添加完成---------------------");
        }else{
            System.out.println("---------------------客户目录已满！---------------------");
        }

    }
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        int i;
        for (;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            i = CMUtility.readInt();
            int total = customerList.getTotal();
            if(i == -1){
                return;
            }else if(i>total){
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }
        }
        //修改客户信息
        Customer cust = customerList.getCustomer(i - 1);
        System.out.print("姓名("+cust.getName()+"):");
        String name = CMUtility.readString(5,cust.getName());
        System.out.print("性别("+cust.getGender()+"):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄("+cust.getAge()+"):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话("+cust.getPhone()+"):");
        String phone = CMUtility.readString(11,cust.getPhone());
        System.out.print("邮箱("+cust.getEmail()+"):");
        String email = CMUtility.readString(20,cust.getEmail());
        Customer newCust = new Customer(name, gender, age, phone, email);
        Boolean isReplaced = customerList.replaceCustomer(i-1,newCust);
        if (isReplaced){
            System.out.println("---------------------修改完成---------------------");
        }else{
            System.out.println("---------------------修改失败---------------------");
        }
    }
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        int i;
        for (;;){
            System.out.print("请选择待删除客户编号(-1退出)：");
            i = CMUtility.readInt();
            int total = customerList.getTotal();
            if(i == -1){
                return;
            }else if(i>total){
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }
        }
        System.out.println("确认是否删除(Y/N)");
        char isY = CMUtility.readConfirmSelection();
        if(isY =='Y'){
            boolean deleteSuccess = customerList.deleteCustomer(i-1);
            if(deleteSuccess){
                System.out.println("---------------------删除完成---------------------");
            }else{
                System.out.println("---------------------删除失败---------------------");
            }
        }
    }
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("没有客户记录！");
        }else{
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            Customer[] custs = customerList.getAllCustomer();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println((i+1) + "\t" + cust.getName() +
                        '\t' + cust.getGender() + '\t'+ cust.getAge() +
                        '\t' + cust.getPhone() + '\t' + cust.getEmail());
            }
        }
        System.out.println("---------------------------客户列表完成---------------------------");
    }
    public static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
