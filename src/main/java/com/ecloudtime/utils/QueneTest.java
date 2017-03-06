package com.ecloudtime.utils;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 用于记录日志的队列，ConcurrentLinkedQueue <br/>
 * 此队列按照 FIFO（先进先出）原则对元素进行排序，详见J2SE_API或JDK
 * 
 * @author RSun 2012-2-22下午05:05:19
 */
public class QueneTest {
	 public static void main(String[] args) throws Exception {  
//	      insertBlocking();  
	      fetchBlocking();  
	          
//	        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);  
//	        testProducerConsumer(abq);  
	          
	    }  
	      
	         
	    /** 
	     * 此方法展示了 ArrayBlockingQueue 的插入阻塞特性 ：如果队列已经满了，那么插入的操作就会被阻塞，程序执行就会被迫暂停。 
	     */  
	    public static void insertBlocking() throws InterruptedException {  
	        ArrayBlockingQueue<String> names = new ArrayBlockingQueue<String>(1);  
	        System.out.println("names.size()"+names.size());
	        names.put("a");  
	        // 从这一句开始后面的就不会被执行了  
	        names.put("b");  
	          
	        System.out.println("names.size()"+names.size());
	        System.out.println("程序执行到此...");  
	    }  
	      
	    /** 
	     * 此方法展示了 ArrayBlockingQueue 的取出阻塞特性 ：如果队列为空，那么取的操作就会被阻塞，程序执行就会报错。 
	     *  
	     */  
	    public static void fetchBlocking() throws InterruptedException {  
	        ArrayBlockingQueue<String> names = new ArrayBlockingQueue<String>(1);  
	        System.out.println("name.size()="+names.size());
	        names.add("a");
	        System.out.println("name.size()="+names.size());
	        if(names.size()>=1){
	        	System.out.println(names.poll());
	        }
	        names.add("2");
	        System.out.println("name.size()="+names.size());
	        names.remove();  
	        System.out.println("name.size()="+names.size());
	        if(names.size()>0)
	        names.remove();  
	        System.out.println("name.size()="+names.size());
	        names.put("b");  
	        System.out.println("name.size()="+names.size());
	          
	        System.out.println("程序执行到此...");  
	    }  
	      
	         
	    /** 
	     * @作用 此方法用来测试生产者和消费者 
	     * 为了让程序在获取不到元素时不报错有两种方式： 
	     * 1.让生产者的生产速度大于消费者的消费速度 
	     * 2.在消费者获取资源出错时让消费者线程暂停一段时间，不输出错误。 
	     * @param abq  
	     */  
	    public static void testProducerConsumer (ArrayBlockingQueue<String> abq) {  
	        Thread tConsumer = new Consumer(abq);  
	        Thread tProducer = new Producer(abq);  
	        tConsumer.start();  
	        tProducer.start();  
	    }  
	      
	}  
	  
	     
	/**             
	 * @作用 定义消费者 
	 *     
	 */         
	class Consumer extends Thread {  
	    ArrayBlockingQueue<String> abq = null;  
	  
	    public Consumer(ArrayBlockingQueue<String> abq) {  
	        super();  
	        this.abq = abq;  
	    }  
	      
	    @Override  
	    public void run() {  
	        while(true) {  
	            try{  
	                Thread.sleep(500);  
	                String msg = abq.remove();  
	                System.out.println("取数据：===="+msg+"\t剩余数据量："+abq.size());  
	            } catch (Exception e) {  
	                try {  
	                    Thread.sleep(2000);  
	                } catch (InterruptedException e1) {  
	                    e1.printStackTrace();  
	                }  
	            }  
	        }  
	    }  
	}  
	  
	     
	/**             
	 * @作用 定义生产者 
	 *     
	 */         
	class Producer extends Thread {  
	    ArrayBlockingQueue<String> abq = null;  
	  
	    public Producer(ArrayBlockingQueue<String> abq) {  
	        this.abq = abq;  
	    }  
	  
	    @Override  
	    public void run() {  
	        int i = 0;  
	        while(true) {  
	            try {  
	                Thread.sleep(1000);  
	                abq.put(""+i);  
	                System.out.println("存放数据：===="+i+"\t剩余数据量："+abq.size());  
	                i++;  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	
	
}
