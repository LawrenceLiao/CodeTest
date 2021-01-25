package com.lawrence.bundlescalculator.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Menu {

    INPUT_ORDER("A", "Input order"),
    EXIT("X", "Exit The System");

    private final String option;
    private final String content;

}
