package com.pbvz01.app.section;

import com.pbvz01.app.constants.SectionConst;

public class SectionFactory {
		private SectionFactory () {}

		public static Section getSection(SectionNumber number) {
				if (number == null) {
						return null;
				}

				Section section;

				switch (number) {
						case SECTION1:
								section = new Section(SectionConst.SECTION_TITLE_1, SectionConst.SECTION1);
								break;
						case SECTION2:
								section = new Section(SectionConst.SECTION_TITLE_2, SectionConst.SECTION2);
								break;
						case SECTION3:
								section = new Section(SectionConst.SECTION_TITLE_3, SectionConst.SECTION3);
								break;
						case SECTION4:
								section = new Section(SectionConst.SECTION_TITLE_4, SectionConst.SECTION4);
								break;
						case SECTION5:
								section = new Section(SectionConst.SECTION_TITLE_5, SectionConst.SECTION5);
								break;
						case SECTION6:
								section = new Section(SectionConst.SECTION_TITLE_6, SectionConst.SECTION6);
								break;
						case SECTION7:
								section = new Section(SectionConst.SECTION_TITLE_7, SectionConst.SECTION7);
								break;
						default:
								return null;
				}
				return section;
		}
}
