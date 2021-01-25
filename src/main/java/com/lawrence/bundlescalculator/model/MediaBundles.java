package com.lawrence.bundlescalculator.model;

import java.util.*;

public class MediaBundles {
    public final static Map<String, List<SubmissionBundles>> BUNDLE_LIST = new HashMap<>();


    static {
        BUNDLE_LIST.put("IMG", new ArrayList<SubmissionBundles>());
        BUNDLE_LIST.put("FLAC", new ArrayList<SubmissionBundles>());
        BUNDLE_LIST.put("VID", new ArrayList<SubmissionBundles>());
        BUNDLE_LIST.get("IMG").add(SubmissionBundles.builder().numPerBundle(5).priceOfBundle(450.0).build());
        BUNDLE_LIST.get("IMG").add(SubmissionBundles.builder().numPerBundle(10).priceOfBundle(800.0).build());
        BUNDLE_LIST.get("FLAC").add(SubmissionBundles.builder().numPerBundle(3).priceOfBundle(427.5).build());
        BUNDLE_LIST.get("FLAC").add(SubmissionBundles.builder().numPerBundle(6).priceOfBundle(810.0).build());
        BUNDLE_LIST.get("FLAC").add(SubmissionBundles.builder().numPerBundle(9).priceOfBundle(1147.5).build());
        BUNDLE_LIST.get("VID").add(SubmissionBundles.builder().numPerBundle(3).priceOfBundle(570.0).build());
        BUNDLE_LIST.get("VID").add(SubmissionBundles.builder().numPerBundle(5).priceOfBundle(900.0).build());
        BUNDLE_LIST.get("VID").add(SubmissionBundles.builder().numPerBundle(9).priceOfBundle(1530.0).build());
    }

}
