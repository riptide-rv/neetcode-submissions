class Solution {
    public class Data implements Comparable<Data> {
        char task;
        Integer freq;

        public Data(char task, Integer freq) {
            this.task = task;
            this.freq = freq;
        }
        
      
        public int compareTo(Data other) {
            return Integer.compare(other.freq, this.freq);
        }
    }
    public int leastInterval(char[] tasks, int n) {
        /*
        Okay, I would not have thoufh this is a heap problem,
        If I get a question how do I identify it is a heap?
        this question in my mind is.
        each cycle i can process one task.
        without heap I would have def thought something like.
        Create a Map of task with count.
        Then for k task
        t1. t2... tk
        and if n < k, sol is direct oh its not wow, yeah because 
        if its something like n = 2 and k = 10 with only some ti having large number 
        then it needs to be interleaved...

        Okay since i know this is heap.. lets think that way at each point what task should I pick

        there are two things I need to keep in mind, when a task was last executed
        and how many of that task is pending?

        Purely speaking from math the task executed first will free up first and 
        I assume its better to execute most repeated task first so that I can do more of that task without having a lot of idle at the end.

        Now is there a case where taking the highest freq first will cause issues?
        yes, because highest freq may not have finished with n
        so lets order by both? last exec first, then freq.
        No that wont work because it will just call t1 to tk inorder.

        ok wait, I need to check (n) , if heap is less then have idle..
        edge case when heap size becomes 0. null is  not needed. 
        
        Yeah see I got solution because ik its heap, I need to first reach conclution than
        n most frequent elements needs to be found, and then the kth large small question is heap.
        
        Ok solution.

        Map the size of each task.
        Create max heap of each task.

        then while size of heap > 0
        reduce one from top n elements , if 0 remove element, else add back. if size < n and heap size not 0. (add nulls)
        
        return answer
        */
        int cycleSize = n + 1;
        Map<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Data> maxHeap = new PriorityQueue<>();

        for (char task: tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        freqMap.forEach((task, freq) -> maxHeap.offer(new Data(task, freq)));

        int result = 0;

        while (maxHeap.size() > 0) {
            int size = maxHeap.size();
            List<Data> rem = new ArrayList<>();
            int toProcess = Math.min(cycleSize, size);
            for (int i = 0; i < toProcess; i++) {
                Data data = maxHeap.poll();
                data.freq--;
                if (data.freq <= 0) continue;
                rem.add(data);
            }
            maxHeap.addAll(rem);

            result = result + toProcess;
            if (!maxHeap.isEmpty() && toProcess < cycleSize) {
                result += (cycleSize - toProcess);
            }
        }


        return result;
        
    }
}
