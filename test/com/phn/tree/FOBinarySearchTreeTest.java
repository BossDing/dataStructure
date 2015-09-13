package com.phn.tree;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 
 * @date 2015年7月29日
 */
public class FOBinarySearchTreeTest {
	public static void main(String[] args) {
		FOBinarySearchTree<String> fobst = new FOBinarySearchTree<String>();
		fobst.add("f");
		fobst.add("e");
		System.out.println(fobst.insert("b"));
		System.out.println(fobst.add("b"));
		fobst.add("a");
		fobst.add("d");
		fobst.add("c");
		fobst.add("i");
		fobst.add("g");
		fobst.add("h");
		fobst.add("j");
		
		
		System.out.println(fobst.preOrderPrint());
		System.out.println(fobst.inOrderPrint());
		System.out.println(fobst.postOrderPrint());
		System.out.println(fobst.contains("a"));
		System.out.println(fobst.contains("v"));
		System.out.println(fobst.remove("a"));
		System.out.println(fobst.preOrderPrint());
		System.out.println(fobst.inOrderPrint());
		System.out.println(fobst.postOrderPrint());
		System.out.println(fobst.remove("e"));
		System.out.println(fobst.preOrderPrint());
		System.out.println(fobst.inOrderPrint());
		System.out.println(fobst.postOrderPrint());

		System.out.println(fobst.remove("k"));
		System.out.println(fobst.preOrderPrint());
		System.out.println(fobst.inOrderPrint());
		System.out.println(fobst.postOrderPrint());
		System.out.println(fobst.getMaxE());
		System.out.println(fobst.getMinE());
	}
}
