package com.lawrence.bundlescalculator.model;

import com.lawrence.bundlescalculator.algorithm.QuotationItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quotation {
    private List<QuotationItem> quotationItems;
}
