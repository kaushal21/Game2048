# Game 2048

*This is a sample game replicating 2048.*

Exam period: 3 hours 15 minutes

You should attempt to answer all questions.
Questions are not of equal value.

You will find five questions in the exam.  Among these, questions, 1,
2, 3, and 5 have coding elements, totalling eight (sub)questions, and
for each of these you will find a separate Java class with FIXME notes
indicating what you need to do.  The number of marks per question varies.
There is one unit test provided for each question with which you may
test your answer.   If a question is worth five marks, you will find 
that there are five unit tests.

For coding questions, the specification of each method you are required to implement is provided in the Javadoc comment immediately above the method. You must adhere to that specification.
You may use any part of the [Java standard API](https://docs.oracle.com/en/java/javase/13/docs/api/index.html) in your solutions, but you may not use other non-standard libraries (such as Apache libraries).
All coding questions are auto-graded; you will be graded according to how many tests you pass. The tests used to grade your work may differ slightly from the tests provided in this repository. Incorrect answers that pass tests will be penalized accordingly.

Fork this repo within GitLab and then clone your copy from within IntelliJ.
Once you have forked the exam:
- answer each question by completing the provided answer file(s) according to the instructions you will find in the file README.md;
- test your answer to each programming question using the provided unit tests; and
- after you complete each question, commit and push your work to GitLab.

*In the real exam, the last commit that you push to GitLab before the end of the exam will be used for marking. **Any commits pushed after the end time of the exam will be ignored and will not count towards your exam mark.** You may commit and push as many times as you wish during the exam time; only the final on-time commit will be marked.*

## Question 1  [15 Marks] 

### Imperative Programming in Java
 
### Q1.1  [5 Marks]  Basic Imperative Programming

Using the incomplete template for [Q1Even.java](src/comp1110/exam/Q1Even.java), complete the unimplemented method `even()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q1.2  [5 Marks]  Recursion

Using the incomplete template for [Q1Fib.java](src/comp1110/exam/Q1Fib.java), complete the unimplemented method `fib()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q1.3  [5 Marks]  Search

Using the incomplete template for [Q1Tour.java](src/comp1110/exam/Q1Tour.java), complete the unimplemented method `tourVictims()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.

## Question 2  [25 Marks]

### Object-Oriented Programming and Abstract Data Types

This question concerns a small piece of software for keeping track of stock in a grocery store.

This question consists of two parts. In the first part, you will design and implement a simple implementation of the software for the grocer, and write a unit test for one of its methods. In the second part, you will implement a similar, but slightly more complicated version of the software.

The software will reduce stock each time stock is sold, increase stock each time new stock arrives, and correct stock levels every time a careful count is made of the actual stock on the store’s shelves (this activity is called a ‘stocktake’).

Each item for sale is called a product. Every product has: a string that uniquely identifies it, called a stock-keeping unit or SKU (e.g. ‘473C2D’); a target stock level, a current stock level; and a name, which is a human-readable string that describes it (e.g. ‘Vegemite, 500g’, or ‘Apple, Granny Smith’).

### Q2.1  [15 Marks]  A Basic Stock Manager
For this part of the question, you will implement your solution in the class  `Q2SimpleStockManager`. For this question, the grocer tells you about unit items. Unit items are products that are bought and sold by count (e.g. 2 jars of jam, 3 ice creams).

Your software must consist of only one outer class (`Q2SimpleStockManager`). Your solution may include one or more inner classes that represent unit items and anything else you decide to include in your design.

### Q2.1.1  [10 Marks]  Software Implementation

Using the incomplete template for [Q2SimpleStockManager.java](src/comp1110/exam/Q2SimpleStockManager.java), complete all *ten* unimplemented methods. You must complete your solution as a single outer class, `Q2SimpleStockManager`. Any additional classes you need must be implemented as inner classes within the `Q2SimpleStockManager` class.
Use the tests provided to test your solution, and then commit and push your changes to GitLab.

### Q2.1.2  [5 Marks]  Software Testing

Using the incomplete template for [Q2TotalStockValueTest.java](src/comp1110/exam/Q2TotalStockValueTest.java), write one or more unit tests for the `totalStockValue()` method. You must complete your solution as a single file, `Q2TotalStockValueTest.java`. When writing the tests, you may assume that the provided methods in the `Q2SimpleStockManager` class are correctly implemented. Once you have completed your tests, commit and push your changes to GitLab.

The specification of the `totalStockValue()` method is provided in the Javadoc comment immediately above the method. This question is auto-graded; your tests will be run against multiple implementations of the `totalStockValue()` method, some of which are correct and some incorrect. You will be graded according to how many correct implementations successfully pass your tests and how many incorrect implementations fail your tests.

### Q2.2  [10 Marks]  A More Complex Stock Manager.

 For this part of the question, you will implement your solution in a class called `Q2StockManager`. For this question, the grocer introduces the idea of vendors. Vendors sell products to the grocer, and one vendor may sell multiple products, but each product comes from only one vendor. Each product is associated with its vendor (and you may assume for the sake of this question that that association never changes). When checking stock quantities, you now need to do so for all stock for a particular vendor.
 
 The `Q2StockManager` class introduces two new methods which you must implement (`newVendor`, `getItemVendorName`), in addition to making other changes compared to your `Q2SimpleStockManager` implementation.
 
 Using the incomplete template for [Q2StockManager.java](src/comp1110/exam/Q2StockManager.java), complete all *eleven* unimplemented methods.
 
 ## Question 3  [20 Marks]  Data Structures
 
 Using the incomplete template for [Q3ArrayList.java](src/comp1110/exam/Q3ArrayList.java), complete the unimplemented methods `add()`, `remove()`, and `reverse()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.
 
 ## Question 4  [20 Marks]  Threads, Complexity, Grammars
 For each of the following multiple-choice questions, identify the choice that provides the best answer.  Record your choices in the file [q-4.csv](q-4.csv), one line per question.
 
 Each question that is correctly answered gains you 5 marks, each question answered incorrectly loses you 1 mark, a question left unanswered neither loses nor gains marks.
 The final mark for this question is calculated by bounding the sum of marks between 0 and 20. For example, if you answered all questions correctly you would gain 20 for this question. If you answer 1 correctly and 2 incorrectly you would gain 3/20 for this question.
 
 ### Q4.1  [5 Marks]  Threads
 Given the following four Java code fragments, identify the one least likely to contain a race condition.
 
 a)
 ````
private void work(int jobnum) {
     try {
 	Thread.sleep(1);
     } catch (InterruptedException e) {
 	e.printStackTrace();
     }
 }
 
 private int incJobNum() {
     return jobnumber++;
 }
 
 @Override
 public void run() {
    int jobnum;
    while ((jobnum = incJobNum()) < WORK_ITEMS) {
        work(jobnum);
    }
 }
````

b)
```` 	
 private void work(int jobnum) {
     try {
 	Thread.sleep(1);
     } catch (InterruptedException e) {
 	e.printStackTrace();
     }
 }
 
 synchronized
 private int incJobNum() {
     return jobnumber++;
 }
 
 @Override
 public void run() {
    int jobnum;
    while ((jobnum = incJobNum()) < WORK_ITEMS) {
        work(jobnum);
    }
 }
 ````

c)
````	
 synchronized
 private void work(int jobnum) {
     try {
 	Thread.sleep(1);
     } catch (InterruptedException e) {
 	e.printStackTrace();
     }
 }
 
 private int incJobNum() {
     return jobnumber++;
 }
 
 @Override
 public void run() {
    int jobnum;
    while ((jobnum = incJobNum()) < WORK_ITEMS) {
        work(jobnum);
    }
 }
 ````

d)
````	
 private void work(int jobnum) {
     Thread.sleep(1);
 }
 
 private int incJobNum() {
     return jobnumber++;
 }
 
 @Override
 public void run() {
    int jobnum;
    while ((jobnum = incJobNum()) < WORK_ITEMS) {
        work(jobnum);
    }
 }
````

### Q4.2  [5 Marks]  Complexity

From among the following, identify the the most accurate statement about computational complexity.

a) The worst-case time complexity of finding an element in a binary search tree is O(log N)

b) The worst-case time complexity of finding an element in a binary search tree is O(N log N)

c) The time complexity of finding an element in a balanced binary search tree is O(N)

d) The time complexity of finding an element in a balanced binary search tree is O(log N)

### Q4.3  [5 Marks]  Recursion

Consider the method `x()` below.
````
static List<Integer> x(List<Integer> in) {
    if (in == null || in.size() <= 1)
	return in;

    int size = in.size();
    List<Integer> l = x(in.subList(0, size/2));
    List<Integer> r = x(in.subList(size/2, size));

    int lf = 0;
    int rf = 0;
    List<Integer> result = new ArrayList<>(size);

    while (lf < l.size() || rf < r.size()) {
	if (lf == l.size() || (rf < r.size() && r.get(rf) < l.get(lf))) {
	    result.add(r.get(rf++));
	} else {
	    result.add(l.get(lf++));
	}
    }
    return result;
}
````

From among the following, select the one that most accurately describes the method `x()` above.

a) x() will divide `in` into two and return the smaller part.

b) x() will divide `in` into two and return the larger part.

c) x() will sort `in` and return the result.

d) x() will return the smallest integer contained in `in`.

### Q4.4  [5 Marks]  Grammars

Given the following EBNF expressions, identify the one that best defines a grammar for accepting four-digit binary numbers (e.g. 1010, 1111, 0001, 1000, etc.).

For reference, some symbols of EBNF are as follows:

````
= defines a production rule
, concatenation
| alternation / choice
[...] optional - zero or one
{...} optional - zero or more
(...) grouping
- exception
; terminates a production rule.
````
    
a) 
````
binary = digit, digit, digit, digit
digit = [ '0' | '1' ]
````

b)
````
binary = [ digit ]
digit = { '0' , '1' }
````

c)
````
binary = digit, digit, digit, digit
digit = '0' | '1'
````

d)
````
binary = [ digit ]
digit = [ '0' | '1' ]
````

## Question 5  [5 Marks]  Hashing

Using the incomplete template for [Q5Hash.java](src/comp1110/exam/Q5Hash.java), complete the unimplemented method `hash()`. Use the tests provided to test your solution, and then commit and push your changes to GitLab.