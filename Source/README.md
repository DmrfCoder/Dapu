# Dapu

DapuAndroid/Source/DaPu/app/src/main/java/cn/xiaojii/dapu/Bean/GlogalBean.java 下public static boolean DEBUG的值调整当前模式:

-  true  调试模式  不会检测用户信息输入是否为空(忽略用户输入的个人信息)
-  false  用户模式  此时会对用户输入的信息进行基础的合法性检测并将用户信息进行保存.