package lambdaTest;


import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.*;
import static java.util.Comparator.comparing;

/**
 * Created by bxguo on 2018/6/7 21:40
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        List<String> strings= Arrays.asList("hehe","","wonking","memeda");
        List<Integer> lengths=map(strings, (String s)->s.length());
        System.out.println("------------>"+lengths);
       // Collections.sort(strings, (item1, item2) -> item1.length() - item2.length() );
        Collections.sort(strings, Comparator.comparingInt(item -> (item+"").length()).reversed());
        strings.forEach(System.out :: println);
        //lengths.sort(comparing(Integer::intValue));
        //lengths.sort((i1,i2)-> i1.compareTo(i2));
        //System.out.println(lengths);
    }

    /**
     *  返回比较器
     * @param keyExtractor
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    /**
     *
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result=new ArrayList<R>(list.size());
        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }

    /**
     *
     * @param list
     * @param p
     * @return
     */
    public static List<Integer> filterOdd(List<Integer> list, Predicate<Integer> p){
        List<Integer> result=new ArrayList<>();
        for(Integer i: list){
            if(p.test(i)){
                result.add(i);
            }
        }
        return result;
    }
}
