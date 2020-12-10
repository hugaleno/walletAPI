package br.com.hcb.wallet.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Response<T> {

    private T data;
    private List<String> errors;

    public Response() {
        errors = new ArrayList<>();
    }

}
