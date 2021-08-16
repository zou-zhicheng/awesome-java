package geektime.spring.springbucks.barista.model;

//  INIT 初始化订单
//  PAID 已付款
//  BREWING 酿造中
//  BREWED  酿造好
//  TAKEN   拿走
//  CANCELLED   取消
public enum OrderState {
    INIT, PAID, BREWING, BREWED, TAKEN, CANCELLED
}
