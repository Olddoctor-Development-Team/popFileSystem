/*   PopFileSystem
 *   Copyright (C) 2021  Olddoctor Development Team
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.

 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   To contact us, please send a e-mail to olddoctor@olddoctor.net.
 */

//PopFilesystem: 程序入口

package net.olddoctor.popFilesystem.manager;

import net.olddoctor.popFilesystem.manager.lib.CmdlineReader;
import net.olddoctor.popFilesystem.manager.lib.Helper;
import net.olddoctor.popFilesystem.manager.lib.NoArgumentException;
import net.olddoctor.popFilesystem.manager.lib.UnknownArgumentException;

public class PopFilesystem {
    public static final boolean debugging = true;

    public static void main(String[] args) {
        try {       //捕获所有代码的异常
            CmdlineReader cmdlineReader = new CmdlineReader(args);
            cmdlineReader.getRunnable().run();


        } catch (NoArgumentException e) {
            Helper.printHelp(2);
        } catch (UnknownArgumentException e) {
            Helper.printHelp(1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
