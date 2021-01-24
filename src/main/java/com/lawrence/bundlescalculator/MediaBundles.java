package com.lawrence.bundlescalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaBundles {
    public final static List<SubmissionBundles> BUNDLE_LIST = Collections.unmodifiableList(new ArrayList<SubmissionBundles>() {

        {
            add(SubmissionBundles.builder().codeOfMedia("IMG").numPerBundle(5).priceOfBundle(450.0).build());
            add(SubmissionBundles.builder().codeOfMedia("IMG").numPerBundle(10).priceOfBundle(800.0).build());
            add(SubmissionBundles.builder().codeOfMedia("FLAC").numPerBundle(3).priceOfBundle(427.5).build());
            add(SubmissionBundles.builder().codeOfMedia("FLAC").numPerBundle(6).priceOfBundle(810.0).build());
            add(SubmissionBundles.builder().codeOfMedia("FLAC").numPerBundle(9).priceOfBundle(1147.5).build());
            add(SubmissionBundles.builder().codeOfMedia("VID").numPerBundle(3).priceOfBundle(570.0).build());
            add(SubmissionBundles.builder().codeOfMedia("VID").numPerBundle(5).priceOfBundle(900.0).build());
            add(SubmissionBundles.builder().codeOfMedia("VID").numPerBundle(9).priceOfBundle(1530.0).build());
        }
    });
}
