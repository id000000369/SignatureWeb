package it.mifsoft.signature.web.dto;

import java.util.List;

public class PageData<T> {
    private long count;
    private Object next;
    private Object previous;
    private List<T> results;

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    public Object getNext() { return next; }
    public void setNext(Object value) { this.next = value; }

    public Object getPrevious() { return previous; }
    public void setPrevious(Object value) { this.previous = value; }

    public List<T> getResults() { return results; }
    public void setResults(List<T> value) { this.results = value; }
}
