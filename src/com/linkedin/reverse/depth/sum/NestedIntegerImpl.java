package com.linkedin.reverse.depth.sum;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    private Integer value;
    private List<NestedInteger> list;

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.value = null;
        this.list = list;
    }

    public NestedIntegerImpl(Integer value) {
        this.value = value;
        this.list = null;
    }

    @Override
    public boolean isInteger() {
        return list == null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
