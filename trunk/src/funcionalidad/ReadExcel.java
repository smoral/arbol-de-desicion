package funcionalidad;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;


public class ReadExcel {
	
		
		public Sheet leerArchivoExcel(String archivoDestino) {
		
			try {
				Workbook archivoExcel = Workbook.getWorkbook(new File(
						archivoDestino));
				//System.out.println("Número de Hojas\t"
				//		+ archivoExcel.getNumberOfSheets());
				//System.out.println(archivoExcel.getSheet(0).getColumns());
				
				Sheet hoja = archivoExcel.getSheet(0);
				/*for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre
				// cada
				// hoja
				{
					Sheet hoja = archivoExcel.getSheet(sheetNo);
					int numColumnas = hoja.getColumns();
					int numFilas = hoja.getRows();
					String data;
					System.out.println("Nombre de la Hoja\t"
							+ archivoExcel.getSheet(sheetNo).getName());
					for (int fila = 0; fila < numFilas; fila++) { // Recorre cada
					// fila de la
					// hoja
						for (int columna = 0; columna < numColumnas; columna++) { // Recorre
						// cada
						// columna
						// de
						// la
						// fila
							data = hoja.getCell(columna, fila).getContents();
							System.out.print(data + " ");

						}
						System.out.println("\n");
					}
				}*/
				return hoja;
			} catch (Exception ioe) {
				ioe.printStackTrace();
			}
			return null;
		}

		/*public static void main(String arg[]) {
			ReadExcel excel = new ReadExcel();
			excel.leerArchivoExcel("TREN2.xls");
		}*/
	}

