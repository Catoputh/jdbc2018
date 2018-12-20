package com.oracle.jdbc;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        int yourInputUserid=222;
        String username="admin";
        Connection con=null;
        Statement  sta=null;
        ResultSet  rs=null;
        try {
            //1.��������������������jdk1.6��ǰ�����ֶ�װ��������1��6�Ժ��������Զ���װ��
           // Class.forName("oracle.jdbc.driver.OracleDriver");

            //2.�������ӣ�ʹ��jdbc api���ṩ��������������һ������
            con= DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.104:1521:XE","store","ok");

            //3.�����ӵĻ����Ͻ����Ự��Statement��
              sta=con.createStatement();//�Ự���������ӵĻ����ϴ���

            //4.ʹ�ûỰ���������ݿⷢ�����ݲ����ı�עָ�SQL��䣩
            String sql="select * from stus where name='"+username+"'";
              rs=sta.executeQuery(sql);

            //5��sql���ִ����ɺ�Ϳ��ԶԲ�����ɶ����ݽ���ҵ�����������ǲ�ѯ�����Ǿ���Ҫ�����������
            while(rs.next()){
                System.out.print(rs.getString("stuname")+"----");;
                System.out.println(rs.getInt(4));
            }

//           int result= sta.executeUpdate("delete  from  stus where stuid=2396");
//            System.out.println(result>0?"ɾ���ɹ�":"ɾ��ʧ��");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(sta!=null) {
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
