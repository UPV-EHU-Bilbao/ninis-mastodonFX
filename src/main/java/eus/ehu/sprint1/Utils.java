package eus.ehu.sprint1;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.WeakListChangeListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Utils {

    public static <S, T> void mapByValue(ObservableList<S> sourceList, ObservableList<T> targetList, Function<S, T> mapper) {
        Objects.requireNonNull(sourceList);
        Objects.requireNonNull(targetList);
        Objects.requireNonNull(mapper);
        targetList.clear();
        Map<S, T> sourceToTargetMap = new HashMap<>();
        // Populate targetList by sourceList and mapper
        for (S s : sourceList)
        {
            T t = mapper.apply(s);
            targetList.add(t);
            sourceToTargetMap.put(s, t);
        }
        // Listen to changes in sourceList and update targetList accordingly
        ListChangeListener<S> sourceListener = new ListChangeListener<S>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends S> c)
            {
                while (c.next())
                {
                    if (c.wasPermutated())
                    {
                        for (int i = c.getFrom(); i < c.getTo(); i++)
                        {
                            int j = c.getPermutation(i);
                            S s = sourceList.get(j);
                            T t = sourceToTargetMap.get(s);
                            targetList.set(i, t);
                        }
                    }
                    else
                    {
                        for (S s : c.getRemoved())
                        {
                            T t = sourceToTargetMap.get(s);
                            targetList.remove(t);
                            sourceToTargetMap.remove(s);
                        }
                        int i = c.getFrom();
                        for (S s : c.getAddedSubList())
                        {
                            T t = mapper.apply(s);
                            targetList.add(i, t);
                            sourceToTargetMap.put(s, t);
                            i += 1;
                        }
                    }
                }
            }
        };
        sourceList.addListener(new WeakListChangeListener<>(sourceListener));
        // Store the listener in targetList to prevent GC
        // The listener should be active as long as targetList exists
        targetList.addListener((InvalidationListener) iv ->
        {
            Object[] refs = { sourceListener, };
            Objects.requireNonNull(refs);
        });
    }
}
