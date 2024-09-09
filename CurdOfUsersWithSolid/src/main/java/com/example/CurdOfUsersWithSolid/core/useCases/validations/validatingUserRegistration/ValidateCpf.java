package com.example.CurdOfUsersWithSolid.core.useCases.validations.validatingUserRegistration;

import com.example.CurdOfUsersWithSolid.adapters.exceptions.CustomValidationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidateCpf implements Validation{
    @Override
    public void validate(String data) {
        var arrNumbers = Arrays.stream(data.split("")).map(Integer::valueOf).toList();


        if(!isTheFistDigit(arrNumbers) || !isTheSecondDigit(arrNumbers)) {
            throw new CustomValidationException("Error! CPF is not valid.");
        }

    }

    private boolean isTheSecondDigit(List<Integer> numbers) {
        return calculate(numbers, 11, 9) == numbers.get(10);
    }

    private boolean isTheFistDigit(List<Integer> numbers) {
       return calculate(numbers, 10, 8) == numbers.get(9);
    }

    private int calculate(List<Integer> numbers, int i, int value) {
        var acc = 0;

        for (var j =0; j <= value; j++) {
            acc += numbers.get(j) * i;
            i--;
        }

        acc = (acc * 10) % 11;

        if(acc >= 10) {
            acc = 0;
        }
        return acc;
    }
}
