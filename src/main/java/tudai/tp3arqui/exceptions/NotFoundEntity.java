package tudai.tp3arqui.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotFoundEntity extends RuntimeException{
    private  final String message;

    public NotFoundEntity(String entity , Long id){
        this.message = String.format("La entidad %s con id %s no existe ", entity,id);
    }
}
