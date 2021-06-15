# 第3章: 数据类型和运算符

# 第4章: 流程控制与数组

# 第5章: 面向对象(上)

通过关键字super 来调用父类的方法或属性

使用初始化块：初始化块由大括号括起{…}，只能由static修饰。

初始化块和构造器：初始化块总在构造器之前执行，初始化块不能接受形参

# 第6章: 面向对象(下)

## 本章要点

- 包装类
- equals、toString方法
- static、**finally**关键字
- abstract关键字和抽象类
- 接口的定义与作用
- 内部类的作用
- 枚举类
- JAR包

Object 类提供的toString方法总是返回该对象实现类的类名 + @ +hashCode值

## 6.1 

WrapperClassCompare.java

```java
// 通过自动装箱，允许把基本类型值赋值给包装类的实例
Integer ina = 2;
Integer inb = 2;
System.out.println("两个2自动装箱后是否相等："
                   + (ina == inb)); // 输出true
Integer biga = 128;
Integer bigb = 128;
System.out.println("两个128自动装箱后是否相等："
                   + (biga == bigb)); // 输出false
```

## 6.2 

EqualTest.java

```javascript
var it = 65;
var fl = 65.0f;
// 将输出true
System.out.println("65和65.0f是否相等？" + (it == fl));
var ch = 'A';
// 将输出true
System.out.println("65和'A'是否相等？" + (it == ch));
var str1 = new String("hello");
var str2 = new String("hello");
```

StringCompareTest.java

```java
// s1直接引用常量池中的"疯狂Java"
var s1 = "疯狂Java";
var s2 = "疯狂";
var s3 = "Java";
// s6后面的字符串值不能在编译时就确定下来，
// 不能引用常量池中的字符串
var s6 = s2 + s3;
// 使用new调用构造器将会创建一个新的String对象，
// s7引用堆内存中新创建的String对象
var s7 = new String("疯狂Java");
System.out.println(s1 == s6); // 输出false
System.out.println(s1 == s7); // 输出false
System.out.println(s6 == s7); // 输出false
```

## 6.4 

FinalErrorTest.java

​	注意final变量的初始化问题

FinalOverload.java

​	final修饰的方法只是不能被重写，完全可以被重载

FinalReplaceTest.java

```java
final var book = "疯狂Java讲义：" + 99.0;
// 下面的book2变量的值因为调用了方法，所以无法在编译时被确定下来
final var book2 = "疯狂Java讲义：" + String.valueOf(99.0);  // ①
// true
System.out.println(book == "疯狂Java讲义：99.0");
// false
System.out.println(book2 == "疯狂Java讲义：99.0");
```

ImmutableStringTest.java

​	注意String的不可变性

ImmutableStringTest.java

​	Integer.valueOf(6)

​	Integer只缓存-128~127之间的值

Person.java

StringJoinTest.java

## 6.6 接口

Output.java

```java
	// 在接口中定义默认方法，需要使用default修饰
	default void print(String... msgs)
	{
		for (var msg : msgs)
		{
			System.out.println(msg);
		}
	}

	// 在接口中定义类方法，需要使用static修饰
	static String staticTest()
	{
		return "接口里的类方法";
	}
	// 定义私有方法
	private void foo()
	{
		System.out.println("foo私有方法");
	}
	// 定义私有静态方法
	private static void bar()
	{
		System.out.println("bar私有静态方法");
	}
```

使用接口可以产生需要设计模式

- 工厂模式
- 命令模式

## 6.7 内部类

AccessStaticInnerClass.java

​	注意: 类里面的静态类可以实例化

CreateInnerInstance.java

```java
Out.In oi = new Out().new In("测试信息");
```

CreateStaticInnerInstance.java

```java
StaticOut.StaticIn in = new StaticOut.StaticIn();
```

DiscernVariable.java

```java
// 在内部函数中调用
// 外部类的实例变量值
OutClass.this.prop
// 内部类的实例变量值
this.prop
```

InnerNoStatic.java

​	非静态内部类不能有静态声明

​	非静态内部类相当于外部类中的**非静态成员变量**，而如果外部类需要调用非静态成员变量就需要先实例化才可以，如果非静态内部类中有静态方法块，那么又可以在加载类的时候提前加载，不需要考虑外部类的实例化，所以有矛盾，所以不可以。

​	为什么非静态内部类中可以有静态常量？（static final）

​	因为常量存放在常量池中，在编译时就已经加载进去了，所以不需要考虑是否静态。

## 6.8 Lambda表达式

LambdaAndInner.java

```java
// 函数式接口
@FunctionalInterface
```

LambdaTest.java

​	同样的Lambda表达式可以被当成不同的目标类型，唯一的要求是：

​	Lambda表达式的形参列表与函数式接口中唯一的抽象方法的形参列表相同

**MethodRefer.java**

**方法引用代替Lambda表达式**

```java
// 下面代码使用Lambda表达式创建Converter对象
// Converter converter1 = from -> Integer.valueOf(from);
// 方法引用代替Lambda表达式：引用类方法。
// 函数式接口中被实现方法的全部参数传给该类方法作为参数。
Converter converter1 = Integer::valueOf;
```

VarInLambda.java

​	使用Lambda表达式对var变量赋值

​	必须显式指定Lambda表达式的目标类型

## 6.9 枚举Enum

### 手动创建枚举类

```
Season.java
SeasonTest.java
```

### JDK 5新增的枚举支持

SeasonEnum.java

一个Java源文件中最多只能定义一个public访问权限的枚举类， 且该Java源文件也必须和该枚举类的类名相同

### 实现接口的枚举类

interface/Gender.java

如果需要每个枚举值在调用同一个方法时呈现出不同的行为方式， 则可以让每个枚举值分别来实现该方法， 每个枚举值提供不同的实现方式， 从而让不同枚举值调用同一个方法时具有不同的行为方式。

## 包含抽象方法的枚举类

可以在枚举类里定义一个抽象方法， 然后把这个抽象方法交给各枚举值去实现即可

定义每个枚举值时必须为抽象方法提供实现， 否则将出现编译错误。

abstact/Operation.java

### 其他

GenderTest.java

```java
// 通过Enum的valueOf()方法来获取指定枚举类的枚举值
Gender g = Enum.valueOf(Gender.class, "FEMALE");
```

better/GenderTest.java

```java
Gender g = Gender.valueOf("FEMALE");
```

best/Gender.java

​	了解一下逐级递进的演变

## 6.10 垃圾回收

PhantomReferenceTest.java

```java
import java.lang.ref.*;

// 创建一个引用队列
var rq = new ReferenceQueue();
		// 创建一个虚引用，让此虚引用引用到"疯狂Java讲义"字符串
		var pr = new PhantomReference(str, rq);
```



## 6.12 打包



# 第7章: 与运行环境交互

## 7.1

KeyboardInTest.java

BufferedReader是Java IO流中的一个字符、 包装流， 它必须建立在另一个字符流的基础之上。 但标准输入： System.in是字节流 ， 程序需要使用转换流InputStreamReader将其包装字符流。

```java
// 以System.in节点流为基础，创建一个BufferedReader对象
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```

## 7.2 Runtime / ProcessHandle

ProcessHandleTest.java

```java
var rt = Runtime.getRuntime();
// 运行记事本程序
Process p = rt.exec("notepad.exe");
ProcessHandle ph = p.toHandle();
// 通过CompletableFuture在进程结束时运行某个任务
CompletableFuture<ProcessHandle> cf = ph.onExit();
cf.thenRunAsync(()->{
  System.out.println("程序退出");
});
```

IdentityHashCodeTest.java

```java
System.identityHashCode(s1)
```

## 7.3 

CloneTest.java

​	CloneNotSupportedException

ObjectsTest.java

```java
import java.util.Objects;
Object obj = null;
Objects.requireNonNull(obj, "obj参数不能是null！"))
```

RandomTest.java

```java
var rand = new Random();
var buffer = new byte[16];
rand.nextBytes(buffer);
```

SeedTest.java

Random里面种子有什么作用?

## 7.4 时间相关

NewDatePackageTest.java

## 7.5 正则表达式

- Pattern
- Matcher

## 7.6 MethodHandle / VarHandle

- MethodHandle 方法处理
- VarHandle 变量处理

通过VarHandle类和MethodHandle类， 允许Java像动态语言一样引用变量、 引用方法， 并调用它们。

MethodHandleTest.java

- findStatic
- findVirtual

```java
import java.lang.invoke.MethodType
import java.lang.invoke.MethodHandles
  
  // 定义一个返回值为void、不带形参的方法类型
  var type = MethodType.methodType(void.class);
// 使用MethodHandles.Lookup的findStatic获取类方法
var mtd = MethodHandles.lookup()
  .findStatic(MethodHandleTest.class, "hello", type);
// 通过MethodHandle执行方法
mtd.invoke();

// 使用MethodHandles.Lookup的findVirtual获取实例方法
var mtd2 = MethodHandles.lookup()
  .findVirtual(MethodHandleTest.class, "hello",
               // 指定获取返回值为String, 形参为String的方法类型
               MethodType.methodType(String.class, String.class));
// 通过MethodHandle执行方法，传入主调对象和参数
System.out.println(mtd2.invoke(new MethodHandleTest(), "孙悟空"));
```

VarHandleTest.java

## 7.7 国际化

# 第8章: Java集合

## 本章重点

• 集合的概念
• Collection接口
• Set接口及其实现类
• List接口及其实现类
• Queue接口及其实现类
• Map接口及其实现类
• HashMap和HashSet的性能选项
• Collections工具类

## 8.2

CollectionStream.java

```java
var books = new HashSet();
books.stream().filter(ele->((String) ele).contains("疯狂")).count()
// 先调用Collection对象的stream()方法将集合转换为Stream,
// 再调用Stream的mapToInt()方法获取原有的Stream对应的IntStream
// 调用forEach()方法遍历IntStream中每个元素
books.stream().mapToInt(ele -> ((String) ele).length())
.forEach(System.out::println);// 输出8 11 16 7 8
```

IntStreamTest.java

```java
import java.util.stream.*;
var is = IntStream.builder()
  .add(20)
  .add(13)
  .add(-2)
  .add(18)
  .build();
// 将is映射成一个新Stream，新Stream的每个元素是原Stream元素的2倍+1
var newIs = is.map(ele -> ele * 2 + 1);
```

IteratorEach.java

```java
// 创建集合、添加元素的代码与前一个程序相同
var books = new HashSet();
// 获取books集合对应的迭代器
var it = books.iterator();
// 使用Lambda表达式（目标类型是Comsumer）来遍历集合元素
it.forEachRemaining(obj -> System.out.println("迭代集合元素：" + obj));

```

PredicateTest.java

```java
var books = new HashSet();
// 使用Lambda表达式（目标类型是Predicate）过滤集合
books.removeIf(ele -> ((String) ele).length() < 10);
```

## 8.3 Set集合

## 8.4 List

```java
var bookList = new ArrayList();
var lit = bookList.listIterator();
lit.hasNext()
lit.next()
lit.hasPrevious()
lit.previous()
```

## 8.5 LinkedList / ArrayDeque

ArrayDeque当作队列

- offer()
- poll()
- peek()

ArrayDeque当作stack

- push()
- poll()
- peek()

# 第9章: 泛型

## 本章要点

• 在集合中使用泛型
• 定义泛型接口、 泛型类
• 类型通配符
• 类型通配符的上限
• 方法签名中定义类型形参
• 类型通配符的下限
• 擦除与转换
• 泛型与数组

## 9.1

AnnoymousDiamond.java

类型通配符的使用

没有太看明白

```java
interface Foo<T>
{
	void test(T t);
}
public class AnnoymousDiamond
{
	public static void main(String[] args)
	{
    Foo<?> f2 = new Foo<>(){ ... }
    // 编译的时候会报错
    // 错误: 不兼容的类型: String无法转换为CAP#1
    //		f2.test(new String("f2"));
    // ^
    //  其中, CAP#1是新类型变量:
    //    CAP#1从?的捕获扩展Object
    // 注: 某些消息已经过简化; 请使用 -Xdiags:verbose 重新编译以获得完整输出
    // 1 个错误
    f2.test(new String("f2"));

    Foo<? extends Number> f3 = new Foo<>(){ ... }
    // 编译的时候报错
    // 错误: 不兼容的类型: Integer无法转换为CAP#1
    // 		f3.test(Integer.valueOf(3));
    // 		                       ^
    //   其中, CAP#1是新类型变量:
    //     CAP#1从? extends Number的捕获扩展Number
    // 注: 某些消息已经过简化; 请使用 -Xdiags:verbose 重新编译以获得完整输出
    // 1 个错误
    f3.test(Integer.valueOf(3));
  }
}
```

## 9.2

A1.java

没看懂

## 9.3

MyUtils.java

​	使用了如下知识点

​	List<? super T>	设定通配符的下限

​	public static <T> T copy(List<? super T> dest, List<T> src)	泛型方法

​	使用泛型方法 **方法中的泛型参数无需显式传入实际类型参数**， 因为编译器根据实参推断类型形参的值。 它通常推断出最直接的类型参数

## 9.4

# 第10章: 异常处理

# 第13章: JDBC编程



# 第14章: 注解

## 14.1 基本注解

ErrorUtils.java

[SafeVarargs的用法 – 宿宝臣的博客 (sdut.edu.cn)](http://softlab.sdut.edu.cn/blog/subaochen/2017/04/safevarargs的用法/)

主要目的是处理可变长参数中的泛型，此注解告诉编译器：在可变长参数中的泛型是类型安全的。可变长参数是使用数组存储的，而数组和泛型不能很好的混合使用

```java
@SafeVarargs
```



FunInterface.java

一.使用规则：

1.必须注解在接口上

2.被注解的接口有且只有一个抽象方法

3.被注解的接口可以有默认方法/静态方法，或者重写Object的方法

4、该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错。

```java
@FunctionalInterface
```

## 14.2

### @Retention

@Retention作用是定义**被它所注解的注解保留多久**，一共有三种策略，定义在RetentionPolicy枚举中.

source：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；被编译器忽略

class：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期

runtime：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在

这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。

那怎么来选择合适的注解生命周期呢？

首先要明确生命周期长度 **SOURCE < CLASS < RUNTIME** ，所以前者能作用的地方后者一定也能作用。一般如果需要**在运行时去动态获取注解信息，那只能用 RUNTIME 注解**；如果要**在编译时进行一些预处理操作**，比如生成一些辅助代码（如 [ButterKnife](https://github.com/JakeWharton/butterknife)）**，就用 CLASS注解**；如果**只是做一些检查性的操作**，比如 **@Override** 和 **@SuppressWarnings**，则**可选用 SOURCE 注解**

### @Target

@Target:注解的作用目标

@Target(ElementType.TYPE)——接口、类、枚举、注解
@Target(ElementType.FIELD)——字段、枚举的常量
@Target(ElementType.METHOD)——方法
@Target(ElementType.PARAMETER)——方法参数
@Target(ElementType.CONSTRUCTOR) ——构造函数
@Target(ElementType.LOCAL_VARIABLE)——局部变量
@Target(ElementType.ANNOTATION_TYPE)——注解
@Target(ElementType.PACKAGE)——包

ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中。
ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中（eg：声明语句、泛型和强制转换语句中的类型）。

### @Documented

**`@Document`：说明该注解将被包含在`javadoc`中**

### @Inherited

**`@Inherited`：说明子类可以继承父类中的该注解**

## 14.3

TypeAnnotationTest.java

Java 8 新特性：扩展注解（类型注解和重复注解）

[Java 8 新特性：扩展注解（类型注解和重复注解）](https://blog.csdn.net/moakun/article/details/80570874)

类型注解（ Type Annotation）

类型注解可用在任何用到类型的地方

Java 8 的类型注解扩展了注解使用的范围。在java 8之前，注解只能是在声明的地方所使用，java8开始，注解可以应用在任何地方

没太看懂

```java
@Target(ElementType.TYPE_USE)
```



## 14.4 

HibernateAnnotationProcessor.java

对于如下原生类的使用

```java
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.lang.model.*;
```

源码级别的注解处理最开始出现于 JAVA 5 中, 它提供了一种在编译期生成额外 “源文件” 的机制. 请注意这个 “源文件” 甚至可以不是 Java 文件, 开发者可以根据源码中的注解利用这一机制, 生成任意文件, 如 描述文件,资源文件, 元数据文件甚至是文档等等.

​	

# 第15章: 输入输出

## 本章要点

• File类的用法
• IO流的功能与用法
• 理解IO流体系
• 重定向标准输入/输出
• 访问其他进程的输入/输出
• RandomAccessFile
• 对象序列化
• Java新IO

## 15.1 

FileTest.java

```java
var file = new File(".");
// 在当前路径下创建一个临时文件
File tmpFile = File.createTempFile("aaa", ".txt", file);
// 指定当JVM退出时删除该文件
tmpFile.deleteOnExit();
```

## 15.4

PushbackTest.java

推回输入流

## 15.8 序列化

SerializeMutable.java

resolve/ResolveTest.java

​	枚举类增加readResolve()方法

replace/ReplaceTest.java

​	重写writeReplace方法，程序在序列化该对象之前，先调用该方法

## 15.9 NIO

BufferTest.java

​	执行flip()之后, 为什么limit会变化

​	flip源代码

```java
public final Buffer flip() {
  limit = position;
  position = 0;
  mark = -1;
  return this;
}
```

CharsetTransform.java

FileChannelTest.java

​	运行出错, 最后解码部分没太看明白

RandomFileChannelTest.java

​	程序之后后并不会自动关闭, 这个程序的意义在哪？

## 15.10 Java 7新增的文件API

WatchServiceTest.java



# 第16章: 多线程



## 16.2 三种方式

- Thread
- Runnable
- Callable

ThirdThread.java

```java
// 先使用Lambda表达式创建Callable<Integer>对象
// 使用FutureTask来包装Callable对象
FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() -> {
  var i = 0;
  for ( ; i < 100; i++)
  {
    System.out.println(Thread.currentThread().getName()
                       + " 的循环变量i的值：" + i);
  }
  // call()方法可以有返回值
  return i;
});
// 实质还是以Callable对象来创建、并启动线程
new Thread(task, "有返回值的线程").start();
```

## 16.4

DaemonThread.java

主线程结束, Daemon线程结束

JoinThread.java

```java
var jt = new JoinThread("被Join的线程");
jt.start();
// main线程调用了jt线程的join()方法，main线程
// 必须等jt执行结束才会向下执行
jt.join();
```

## 16.5 线程同步

synchronizedMethod/

synchronizedBlock/

```java
// 使用account作为同步监视器，任何线程进入下面同步代码块之前，
// 必须先获得对account账户的锁定——其他线程无法获得锁，也就无法修改它
// 这种做法符合：“加锁 → 修改 → 释放锁”的逻辑
synchronized (account)
{
}
// 同步代码块结束，该线程释放同步锁
```

Lock/

```java
// 定义锁对象
private final ReentrantLock lock = new ReentrantLock();
// 加锁
lock.lock();
try{
  ...
}finally{
  // 修改完成，释放锁
  lock.unlock();
}
```

## 16.6 线程的协调运行

condition/

使用条件变量控制协调

使用Condition可以让那些已经得到Lock对象、 却无法继续执行的线程释放
Lock对象， Condtion对象也可以唤醒其他处于等待的线程

与synchronized/方法中的wait(), notify()等有什么区别呢?

```java
// 显式定义Lock对象
private final Lock lock = new ReentrantLock();
// 获得指定Lock对象对应的Condition
private final Condition cond = lock.newCondition();
// 加锁
lock.lock();
try{
  // 方法阻塞
  cond.await();
  // 唤醒其他线程
  cond.signalAll();
}finally{
  // 使用finally块来释放锁
  lock.unlock();
}
```

## 16.7 线程组

ExHandler.java

```java
// 设置主线程的异常处理器
Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
```

ThreadGroupTest.java

```java
// 获取主线程所在的线程组，这是所有线程默认的线程组
ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
var tt = new MyThread(tg, "tg组的线程甲");
```

## 16.8 线程池

ThreadPoolTest.java

```java
// ExecutorService代表尽快执行线程的线程池
// ScheduledExecutorService代表可在指定延迟， 或周期性执行线程任务的线程池
ExecutorService pool = Executors.newFixedThreadPool(6);
// 向线程池中提交两个线程
pool.submit(target);
pool.submit(target);
// 关闭线程池
pool.shutdown();
```

ForkJoinPoolTest.java

```java
// 继承RecursiveAction来实现"可分解"的任务
class PrintTask extends RecursiveAction
{
	@Override
	protected void compute()
	{
			// 如果当end与start之间的差大于THRESHOLD时，即要打印的数超过50个
			// 将大任务分解成两个小任务。
			int middle = (start + end) / 2;
			var left = new PrintTask(start, middle);
			var right = new PrintTask(middle, end);
			// 并行执行两个“小任务”
			left.fork();
			right.fork();
	}
}

public class ForkJoinPoolTest
{
	public static void main(String[] args)
		throws Exception
	{
		var pool = new ForkJoinPool();
		// 提交可分解的PrintTask任务
		pool.submit(new PrintTask(0, 300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		// 关闭线程池
		pool.shutdown();
	}
}
```

Sum.java

```java
// 继承RecursiveTask来实现"可分解"的任务
class CalTask extends RecursiveTask<Integer>
{
	@Override
	protected Integer compute()
  {
			// 如果当end与start之间的差大于THRESHOLD时，即要累加的数超过20个时
			// 将大任务分解成两个小任务。
			int middle = (start + end) / 2;
			var left = new CalTask(arr, start, middle);
			var right = new CalTask(arr, middle, end);
			// 并行执行两个“小任务”
			left.fork();
			right.fork();
			// 把两个“小任务”累加的结果合并起来
			return left.join() + right.join();    // ①
  }
}

public class Sum
{
	public static void main(String[] args)
		throws Exception
  {
		// 创建一个通用池
		ForkJoinPool pool = ForkJoinPool.commonPool();
		// 提交可分解的CalTask任务
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		// 关闭线程池
		pool.shutdown();
  }
}
```

## 16.9 发布-订阅框架

ThreadLocalTest.java

```java
	/* 定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量
	每个线程都会保留该变量的一个副本 */
	private ThreadLocal<String> name = new ThreadLocal<>();
```

PubSubTest.java

发布-订阅

# 第17章: 网络编程

## 17.3 

MultiThread/

加入多线程支持

NoBlock/

NIO的非阻塞通信

没太看明白, 需要去看书



# 第18章: 类加载和类反射

