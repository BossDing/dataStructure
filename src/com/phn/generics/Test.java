package com.phn.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO
 存取原则和PECS法则

总结 ? extends 和 the ? super 通配符的特征，我们可以得出以下结论：

如果你想从一个数据类型里获取数据，使用 ? extends 通配符
如果你想把对象写入一个数据结构里，使用 ? super 通配符
如果你既想存，又想取，那就别用通配符。
 * @date 2015年9月17日
 */
public class Test {
	public static void main(String[] args) {
		List<Student> stus = new ArrayList<Student>();
		stus.add(new Student());
		
		List<People> peos = new ArrayList<People>();
		peos.add(new Student());
		// peos = stus;//编译不通过
		
		List<? extends People> test1 = new ArrayList<Student>();
//		test1.add(new Student());//编译不通过
		test1.add(null);
//		test1.add(new People());//编译不通过
		System.out.println(test1);
		List<? extends People> test11 = stus;
		System.out.println(test11);
		
		List<? super Student> test2 = new ArrayList<Student>();
		test2.add(new Student());
		test2.add(new SmallStudent());
//		test2.add(new People());//编译不通过
		
		List<? super People> test3 = new ArrayList<People>();
		test3.add(new Student());
		test3.add(new SmallStudent());
		test3.add(new People());
		
		List<? super Student> test4 = new ArrayList<People>();
//		List<? super Student> test5 = new ArrayList<SmallStudent>();//编译不通过
	}
}
