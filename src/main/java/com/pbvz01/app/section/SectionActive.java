package com.pbvz01.app.section;

public class SectionActive
{
		private static Section activeSection;
		private SectionActive(){}

		public static void setActiveSection(Section section)
		{
				activeSection = section;
		}

		public static Section getActiveSection()
		{
				if(activeSection != null) return activeSection;
				return null;
		}
}
