/* Hot Key Tester
 * v 1.0 
 * 2020-09-24 */
package mainPack;

/* Anv�nds enbart f�r att omvandla knapptryckning(char) till en representerande int. Egen klass
 * f�r detta m�jligg�r att fler hotkeys enkelt kan l�ggas till i framtiden*/
public class HotKeyTester {

	public static int testHotKey(char key) {
		switch (key) {
		case 't':
				return 1;
		case 'y':
				return 2;
		case 'u':
				return 3;
		case 'g':
				return 4;
		case 'h':
				return 5;
		case 'j':
				return 6;
		case 'b':
				return 7;
		case 'n':
				return 8;
		case 'm':
				return 9;
		default:
			return 0;
			
		}
	}
}
