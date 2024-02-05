package ru.spring.hw8task2.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {

  private long senderAccountId;
  private long receiverAccountId;
  private BigDecimal amount;

  public TransferRequest(long senderAccountId, long receiverAccountId, BigDecimal amount) {
    this.senderAccountId = senderAccountId;
    this.receiverAccountId = receiverAccountId;
    this.amount = amount;
  }
}
