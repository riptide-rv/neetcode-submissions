class MedianFinder {

    /*
       

        9 7 1 3 8 6 4 5 2

        max heap 1 2 3 4 5  
        min heap 6 7 8 9

         
    */
    int total = 0;
    PriorityQueue<Integer> secondHalf = new PriorityQueue<>();
    PriorityQueue<Integer> firstHalf = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        this.total++;
        if (this.firstHalf.isEmpty()) {
            this.firstHalf.offer(num);
            return;
        }
        if (num <= this.firstHalf.peek()) this.firstHalf.offer(num);
        else this.secondHalf.offer(num);

        if (this.firstHalf.size() - this.secondHalf.size() > 1) {
            this.secondHalf.offer(this.firstHalf.poll());
            return;
        } 
        if (this.secondHalf.size() - this.firstHalf.size() > 1) {
            this.firstHalf.offer(this.secondHalf.poll());
        }
        
    }
    
    public double findMedian() {
        if (this.firstHalf.size() == this.secondHalf.size()) {
            return (double)(this.firstHalf.peek() + this.secondHalf.peek()) / 2;
        }

        if (this.firstHalf.size() > this.secondHalf.size()) {
            return this.firstHalf.peek();
        }

        return this.secondHalf.peek();
        
    }
}
