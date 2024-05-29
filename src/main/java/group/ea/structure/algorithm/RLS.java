package group.ea.structure.algorithm;

import group.ea.structure.helperClasses.Data;
import group.ea.structure.problem.Problem;
import group.ea.structure.searchspace.SearchSpace;

import java.util.Optional;

public class RLS extends Algorithm {

    public RLS(SearchSpace searchSpace, Problem problem) {
        super(searchSpace, problem);


    }

    @Override
    public void initialize() {
        bitString = searchSpace.init();
        bestFitness = (int) problem.computeFitness(bitString);


    }

    @Override
    public void performSingleUpdate(int generation) {
        if(generation == 0){
            Data firstData = new Data(bitString, 0, bestFitness, true, Optional.empty());
            listener.receiveBitstringUpdate(firstData);
        }
        String offspring = mutate(bitString);
        int offspringFitness = (int) problem.computeFitness(offspring);
        Data data = new Data(bitString, generation, bestFitness, false, Optional.empty());
        if (offspringFitness > bestFitness) {
            bitString = offspring;
            bestFitness = offspringFitness;
            data.setBitString(bitString);
            data.setFitness(bestFitness);
            data.setYesNo(true);
        }
        listener.receiveBitstringUpdate(data);
        finalList.add(data);
    }

    private String mutate(String parent) {
        int mutateIndex = (int) (Math.random() * parent.length());
        char[] chars = parent.toCharArray();
        chars[mutateIndex] = chars[mutateIndex] == '0' ? '1' : '0';
        return new String(chars);
    }


}
