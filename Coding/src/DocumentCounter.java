/* Class and function to count documents */

public class DocumentCounter {
	
    public class Counter {
        private int count = 0;
        private int increment;

        public Counter(int increment) {
            this.increment = increment;
        }

        public int getAndIncrement() {
            this.count += this.increment;
            return this.count;
        }
    }

    public class DocumentNameCreator {
        private String prefix;
        
        DocumentCounter counter = new DocumentCounter();
        
        public DocumentNameCreator(int increment, String prefix) {
        	new Counter(increment);
            this.prefix = prefix;
        }

        public DocumentNameCreator(String prefix, Counter counter) {
            this.prefix = prefix;
        }
    }
}