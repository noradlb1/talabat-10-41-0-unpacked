package com.google.firebase.icing;

public final class R {

    public static final class attr {
        public static final int allowShortcuts = 2130968650;
        public static final int contentProviderUri = 2130969000;
        public static final int corpusId = 2130969016;
        public static final int corpusVersion = 2130969017;
        public static final int defaultIntentAction = 2130969103;
        public static final int defaultIntentActivity = 2130969104;
        public static final int defaultIntentData = 2130969105;
        public static final int documentMaxAgeSecs = 2130969154;
        public static final int featureType = 2130969261;
        public static final int indexPrefixes = 2130969443;
        public static final int inputEnabled = 2130969454;
        public static final int noIndex = 2130969860;
        public static final int paramName = 2130969901;
        public static final int paramValue = 2130969902;
        public static final int perAccountTemplate = 2130969918;
        public static final int schemaOrgProperty = 2130970080;
        public static final int schemaOrgType = 2130970081;
        public static final int searchEnabled = 2130970100;
        public static final int searchLabel = 2130970103;
        public static final int sectionContent = 2130970109;
        public static final int sectionFormat = 2130970110;
        public static final int sectionId = 2130970111;
        public static final int sectionType = 2130970112;
        public static final int sectionWeight = 2130970113;
        public static final int semanticallySearchable = 2130970124;
        public static final int settingsDescription = 2130970137;
        public static final int sourceClass = 2130970231;
        public static final int subsectionSeparator = 2130970308;
        public static final int toAddressesSection = 2130970512;
        public static final int trimmable = 2130970551;
        public static final int userInputSection = 2130970581;
        public static final int userInputTag = 2130970582;
        public static final int userInputValue = 2130970583;

        private attr() {
        }
    }

    public static final class id {
        public static final int contact = 2131428426;
        public static final int date = 2131428589;
        public static final int demote_common_words = 2131428692;
        public static final int demote_rfc822_hostnames = 2131428693;
        public static final int email = 2131428868;
        public static final int html = 2131429314;
        public static final int icon_uri = 2131429410;
        public static final int index_entity_types = 2131429490;
        public static final int instant_message = 2131429680;
        public static final int intent_action = 2131429682;
        public static final int intent_activity = 2131429683;
        public static final int intent_data = 2131429684;
        public static final int intent_data_id = 2131429685;
        public static final int intent_extra_data = 2131429686;
        public static final int large_icon_uri = 2131429844;
        public static final int match_global_nicknames = 2131430109;
        public static final int omnibox_title_section = 2131430403;
        public static final int omnibox_url_section = 2131430404;
        public static final int plain = 2131430652;
        public static final int rfc822 = 2131431043;
        public static final int text1 = 2131431743;
        public static final int text2 = 2131431744;
        public static final int thing_proto = 2131431871;
        public static final int url = 2131432340;

        private id() {
        }
    }

    public static final class styleable {
        public static final int[] AppDataSearch = new int[0];
        public static final int[] Corpus = {com.talabat.R.attr.contentProviderUri, com.talabat.R.attr.corpusId, com.talabat.R.attr.corpusVersion, com.talabat.R.attr.documentMaxAgeSecs, com.talabat.R.attr.perAccountTemplate, com.talabat.R.attr.schemaOrgType, com.talabat.R.attr.semanticallySearchable, com.talabat.R.attr.trimmable};
        public static final int Corpus_contentProviderUri = 0;
        public static final int Corpus_corpusId = 1;
        public static final int Corpus_corpusVersion = 2;
        public static final int Corpus_documentMaxAgeSecs = 3;
        public static final int Corpus_perAccountTemplate = 4;
        public static final int Corpus_schemaOrgType = 5;
        public static final int Corpus_semanticallySearchable = 6;
        public static final int Corpus_trimmable = 7;
        public static final int[] FeatureParam = {com.talabat.R.attr.paramName, com.talabat.R.attr.paramValue};
        public static final int FeatureParam_paramName = 0;
        public static final int FeatureParam_paramValue = 1;
        public static final int[] GlobalSearch = {com.talabat.R.attr.defaultIntentAction, com.talabat.R.attr.defaultIntentActivity, com.talabat.R.attr.defaultIntentData, com.talabat.R.attr.searchEnabled, com.talabat.R.attr.searchLabel, com.talabat.R.attr.settingsDescription};
        public static final int[] GlobalSearchCorpus = {com.talabat.R.attr.allowShortcuts};
        public static final int GlobalSearchCorpus_allowShortcuts = 0;
        public static final int[] GlobalSearchSection = {com.talabat.R.attr.sectionContent, com.talabat.R.attr.sectionType};
        public static final int GlobalSearchSection_sectionContent = 0;
        public static final int GlobalSearchSection_sectionType = 1;
        public static final int GlobalSearch_defaultIntentAction = 0;
        public static final int GlobalSearch_defaultIntentActivity = 1;
        public static final int GlobalSearch_defaultIntentData = 2;
        public static final int GlobalSearch_searchEnabled = 3;
        public static final int GlobalSearch_searchLabel = 4;
        public static final int GlobalSearch_settingsDescription = 5;
        public static final int[] IMECorpus = {com.talabat.R.attr.inputEnabled, com.talabat.R.attr.sourceClass, com.talabat.R.attr.toAddressesSection, com.talabat.R.attr.userInputSection, com.talabat.R.attr.userInputTag, com.talabat.R.attr.userInputValue};
        public static final int IMECorpus_inputEnabled = 0;
        public static final int IMECorpus_sourceClass = 1;
        public static final int IMECorpus_toAddressesSection = 2;
        public static final int IMECorpus_userInputSection = 3;
        public static final int IMECorpus_userInputTag = 4;
        public static final int IMECorpus_userInputValue = 5;
        public static final int[] Section = {com.talabat.R.attr.indexPrefixes, com.talabat.R.attr.noIndex, com.talabat.R.attr.schemaOrgProperty, com.talabat.R.attr.sectionFormat, com.talabat.R.attr.sectionId, com.talabat.R.attr.sectionWeight, com.talabat.R.attr.subsectionSeparator};
        public static final int[] SectionFeature = {com.talabat.R.attr.featureType};
        public static final int SectionFeature_featureType = 0;
        public static final int Section_indexPrefixes = 0;
        public static final int Section_noIndex = 1;
        public static final int Section_schemaOrgProperty = 2;
        public static final int Section_sectionFormat = 3;
        public static final int Section_sectionId = 4;
        public static final int Section_sectionWeight = 5;
        public static final int Section_subsectionSeparator = 6;

        private styleable() {
        }
    }

    private R() {
    }
}
