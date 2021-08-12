package com.matthew.seckillstage.common.exception;

import com.matthew.seckillstage.common.CodeMessage;

public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMessage codeMessage;

    public ApplicationException(CodeMessage codeMessage) {
        super(codeMessage.toString());
        this.codeMessage = codeMessage;
    }

    public CodeMessage getCodeMessage() {
        return codeMessage;
    }
}
