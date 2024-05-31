package group.ea.structure.algorithm;


public class MaxGenerationsCriterion implements StoppingCriterion {
        private int maxGenerations;

        public MaxGenerationsCriterion(int max) {
            this.maxGenerations = max;
        }

        @Override
        public boolean isMet(Algorithm algorithm) {
            return algorithm.getGeneration() >= maxGenerations;
        }
    }