package sample.domain.errors;

public class MultipleInstancesFound extends  Exception{
    public MultipleInstancesFound() {
        super("There are multiple instances found in db ");
    }
}
