package com.rpc.pdfinvoicespringboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Invoice {

    private String userId, pdfUrl;

    private Integer amount, id;
}
