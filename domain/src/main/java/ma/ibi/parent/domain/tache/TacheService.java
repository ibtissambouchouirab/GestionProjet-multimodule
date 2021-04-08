package ma.ibi.parent.domain.tache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TacheService {

    private final  TacheProvider tacheProvider;

    public List<TacheAggregete> getAll(){
        return tacheProvider.getAll();
    }
    public void addTache(TacheAggregete tacheAggregete){

        tacheProvider.addTache(tacheAggregete);
    }

    public void deleteAll(){
        tacheProvider.deleteAll();
    }

    public void deleteTache(String code){
        tacheProvider.deleteTache(code);
    }
}
