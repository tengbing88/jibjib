package de.cdvost.jibjib.domain.interactors.room;

import de.cdvost.jibjib.domain.executor.Executor;
import de.cdvost.jibjib.domain.executor.MainThread;
import de.cdvost.jibjib.domain.interactors.base.AbstractInteractor;
import de.cdvost.jibjib.repository.room.IRoomDataBaseRepository;
import de.cdvost.jibjib.repository.room.RoomDataBaseRepository;

public abstract class BaseDBInteractor extends AbstractInteractor {

    protected IRoomDataBaseRepository repository;

    public BaseDBInteractor(Executor threadExecutor, MainThread mainThread, Callback callback) {
        super(threadExecutor, mainThread, callback);
        this.repository = new RoomDataBaseRepository();
    }
}