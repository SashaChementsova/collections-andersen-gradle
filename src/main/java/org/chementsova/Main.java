package org.chementsova;

import org.chementsova.arrayList.CustomList;
import org.chementsova.arrayList.implementation.CustomArrayList;
import org.chementsova.hashSet.implementation.CustomHashSet;

public class Main
{
    public static void main( String[] args )
    {
        CustomList<Integer> arrayList = new CustomArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        for(int i = 0; i < arrayList.getSize(); i ++){
            System.out.println(arrayList.get(i));
        }
        arrayList.remove(1);
        for(int i = 0; i < arrayList.getSize(); i ++){
            System.out.println(arrayList.get(i));
        }

        CustomHashSet<String> hashSet = new CustomHashSet<>();
        hashSet.put("Sasha");
        hashSet.put("Inna");
        hashSet.put("Anya");
        hashSet.put("Sasha");
        for(String s : hashSet){
            System.out.println(s);
        }
        hashSet.remove("Inna");
        for(String s : hashSet){
            System.out.println(s);
        }
        System.out.println(hashSet.contains("Inna"));
    }
}
