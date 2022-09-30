package com.pbvz01.app.section;

import com.pbvz01.app.constants.SectionConst;

public class Section
{
		private String title;
		private String path;

		public Section (String title, String numberSection) {
				this.title = title;
				this.path = setCorrectPathToSources(numberSection);
		}

		public String getTitle() {
				return this.title;
		}

		public String getPath () {
				return this.path;
		}

		private String setCorrectPathToSources(String numberSection) {
				return SectionConst.PATH_TO_SECTIONS + numberSection;
		}
}
