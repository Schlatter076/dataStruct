package loyer.convert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyConvert {
  private static final int SYSTEM_HEX = 16;
  
  public static void main(String[] args) {
    System.out.println(convertByStack(100, 8));
  }
  /**
   * 进制转换
   * @param number 待转换的数字
   * @param system 进制数
   * @return 转换后的数的字符串形式
   */
  public static String convertByStack(int number, int system) {
    Stack<String> stack  = new Stack<>();
    while(number > 0) {
      String numStr = getNumber(number, system);
      stack.push(numStr);
      number /= system;
    }
    StringBuilder builder = new StringBuilder();
    while(!stack.isEmpty()) {
      builder.append(stack.pop());
    }
    return builder.toString();
  }
  /**
   * 取余，用来存放到栈
   * @param number 待转换的数字
   * @param system 进制数
   * @return 余数
   */
  private static String getNumber(int number, int system) {
    Map<Integer, String> hexMap = new HashMap<>();
    hexMap.put(10, "A");
    hexMap.put(11, "B");
    hexMap.put(12, "C");
    hexMap.put(13, "D");
    hexMap.put(14, "E");
    hexMap.put(15, "F");
    
    int mod = number % system;
    if(system == SYSTEM_HEX && mod >= 10) {
      return hexMap.get(mod);
    }
    else 
      return String.valueOf(mod);
  }

}
