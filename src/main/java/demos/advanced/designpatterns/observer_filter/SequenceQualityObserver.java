package demos.advanced.designpatterns.observer_filter;

/**
 * Observer dedicated to monitoring sequence quality of the sequences generated by the real time sequencer.
 * Created by michiel on 07/03/2017.
 */
public class SequenceQualityObserver extends AbstractSequenceObserver {
    private int lowQualityCount = 0;
    private int maxLowQualityCount = 3;

    @Override
    public void newSequenceDetermined(Sequence sequence) {
        boolean accept = this.applyFilters(sequence);
        if (!accept) {
            System.out.println(">>>" + this.getClass().getSimpleName() + " does not accept sequence!");
            lowQualityCount++;

            if (lowQualityCount >= maxLowQualityCount) {
                System.out.println(">>>>> Stop the sequencer? <<<<");
                System.out.println(">>>>> Too expensive; change the quality filter and increase cutoff <<<<");
                this.clearFilters();
                this.addSequenceFilter(new SequenceFilter() {
                    @Override
                    public boolean filter(Sequence sequence) {
                        return !sequence.quality().contains("!!!");
                    }
                });
                this.maxLowQualityCount = 6;
            }
        }

    }
}
