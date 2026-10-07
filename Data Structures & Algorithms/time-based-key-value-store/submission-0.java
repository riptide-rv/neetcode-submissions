class TimeMap {
    /*
        key: (timestamp, value) sorted list. manual sorting or a priority queue is best,
        insertion find timestamp and replace or add
        get find timestamp or less and return.
    */

    class TimeValue {
        private String value;
        private int timestamp;

        public TimeValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }
        public int getTimestamp() {
            return this.timestamp;
        }
    }

    private HashMap<String, List<TimeValue>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TimeValue val = new TimeValue(value, timestamp);
        if (!this.map.containsKey(key)) {
            List<TimeValue> newList = new ArrayList<TimeValue>();
            newList.add(val);
            this.map.put(key, newList);
            return;
        }

        List<TimeValue> list = this.map.get(key);
        int listLength = list.size();
        int index = this.binarySearch(list, timestamp);

        if (index >= listLength) {
            list.add(val);
            return;
        }
        TimeValue temp = list.get(index);
        if (temp.getTimestamp() == val.getTimestamp()) {
            list.set(index, val);
        } else {
            list.add(index, val);
        }
    }

    public String get(String key, int timestamp) {
        List<TimeValue> list = this.map.get(key);
        if (list == null || list.isEmpty()) {
            return "";
        }

        int index = this.binarySearch(list, timestamp);
        if (index < list.size() && list.get(index).getTimestamp() == timestamp) {
            return list.get(index).getValue();
        }
        if (index == 0) {
            if (list.getFirst().getTimestamp() < timestamp) {
                return list.getFirst().getValue();
            } 
            return "";
        } else {
            return list.get(index - 1).getValue();
        }
    }

    private int binarySearch(List<TimeValue> sortedList, int target) {
        
        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            TimeValue midItem = sortedList.get(mid);
            if (midItem.getTimestamp() == target) {
                return mid;
            } else if (midItem.getTimestamp() > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
